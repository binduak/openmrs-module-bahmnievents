package org.bahmni.module.events.ipd.service;

import org.bahmni.module.events.api.ipd.model.IpdSchedule;
import org.bahmni.module.events.api.ipd.model.IpdSlot;
import org.bahmni.module.events.api.ipd.service.IpdScheduleService;
import org.bahmni.module.events.api.ipd.service.IpdSlotService;
import org.bahmni.module.events.ipd.dto.DrugChartRequest;
import org.bahmni.module.events.ipd.dto.DrugChartResponse;
import org.openmrs.Order;
import org.openmrs.api.ConceptService;
import org.openmrs.api.OrderService;
import org.openmrs.module.fhir2.model.FhirReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.openmrs.Concept;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugChartService {

    @Autowired
    private IpdScheduleService ipdScheduleService;
    @Autowired
    private IpdSlotService ipdSlotService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ConceptService conceptService;

    public DrugChartResponse buildDrugChart(DrugChartRequest drugChartRequest) {

        IpdSchedule ipdSchedule = new IpdSchedule();
        // get start date from order
        Order order = orderService.getOrderByUuid(drugChartRequest.getOrderUuid());

        // create a concept for MAR
        Concept concept = conceptService.getConceptByName("MAR");

        FhirReference fhirReference = new FhirReference();
        fhirReference.setTargetUuid(drugChartRequest.getPatientUuid());
        fhirReference.setType("Patient");
        ipdSchedule.setForReference(fhirReference);

        ipdSchedule.setActive(true);
        ipdSchedule.setStartDate(order.getEffectiveStartDate());
        ipdSchedule.setEndDate(order.getEffectiveStopDate());

        ipdScheduleService.save(ipdSchedule);

        List<IpdSlot> ipdSlotList = new ArrayList<>();
        for (int i = 0; i < drugChartRequest.getSlots().size(); i++) {
            IpdSlot ipdSlot = new IpdSlot();
            ipdSlot.setStartDate(drugChartRequest.getSlots().get(i));
            ipdSlot.setEndDate(drugChartRequest.getSlots().get(i));
            ipdSlot.setStatus(IpdSlot.SlotStatus.REQUESTED);
            ipdSlot.setScheduleId(ipdSchedule);
            ipdSlot.setOverbooked(false);
            ipdSlot.setServiceTyppeId(concept);
            ipdSlot.setOrderId(order);
            //ipdSlot.location
            ipdSlotList.add(ipdSlot);
        }
        return null;
    }


}
