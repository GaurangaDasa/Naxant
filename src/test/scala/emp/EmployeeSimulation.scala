package emp

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class EmployeeSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://ocsp.digicert.com")
		.inferHtmlResources()

	val headers_0 = Map("Range" -> "bytes=0-299999")

    val uri1 = "download.mozilla.org"
    val uri2 = "http://172.27.171.96:15871"
    val uri3 = "ocsp.digicert.com"

	val scn = scenario("EmployeeSimulation")
		.exec(http("request_0")
			.get("http://" + uri1 + "/?product=firefox-43.0.1-complete&os=win&lang=en-US")
			.headers(headers_0))
		.pause(3)
		.exec(http("request_1")
			.post("/")
			.body(RawFileBody("EmployeeSimulation_0001_request.txt")))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}