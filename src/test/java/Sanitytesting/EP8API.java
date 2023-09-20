package Sanitytesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class EP8API {
	  @Test(priority=4)
	    void Ep8Loading() {
	        System.out.println("Sending post request of to detect EP8 cell count");
	        given()
	            .auth()
	            .preemptive()
	            .basic("admin", "admin")
	            .formParam("tilecornercoords","20480,-22528,20992,-22528,20992,-23040,20480,-23040")
	            .formParam("iipsrv", "https://apollo2.humanbrain.in/iipsrv1/fcgi-bin/iipsrv.fcgi?FIF=/data/storageIIT/humanbrain/analytics/141/NISL/B_141_FB40-SL_67-ST_NISL-SE_199_lossless.jp2&GAM=1.5&WID=512&RGN=0.5460750853242321,0.5530922393263117,0.013651877133105802,0.012570278166507083&CVT=jpeg")
	            .formParam("secno", "199") 
	            .formParam("biosampleid","141")
	            .when()
	            .post("https://apollo2.humanbrain.in/ml/predictions/ep8")
	        .then()
	            .statusCode(200)
	            .log().all();
	    }
}
