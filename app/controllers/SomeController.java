package controllers;

import play.*;
import play.mvc.*;
import java.util.Map;
import java.util.HashMap;

import models.*;
import controllers.*;

public class SomeController extends Controller {

  public static void download_report() {
    Map reportParams = new HashMap();
    //jrxml and jasper files should be in app/reports
    renderBinary(lib.reports.BaseJasperReport.generateReport("SomeReport", reportParams), "some_report.xls");
  }
}