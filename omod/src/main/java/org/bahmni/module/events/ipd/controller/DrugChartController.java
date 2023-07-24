package org.bahmni.module.events.ipd.controller;

import org.bahmni.module.events.ipd.dto.DrugChartRequest;
import org.bahmni.module.events.ipd.dto.DrugChartResponse;
import org.bahmni.module.events.ipd.service.DrugChartService;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/v1/drugChart")
public class DrugChartController extends BaseRestController {

    @Autowired
    private DrugChartService drugChartService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public DrugChartResponse createDrugChart(@RequestBody DrugChartRequest drugChartRequest) {
        DrugChartResponse response = new DrugChartResponse();
//        response.setPatientUuid(drugChartService.c
//                createDrugChart(drugChartRequest.getPatientUuid()));
        return response;
    }

}
