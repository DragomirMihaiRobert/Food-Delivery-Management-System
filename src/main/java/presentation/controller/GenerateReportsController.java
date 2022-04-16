package presentation.controller;

import business.DeliveryService;
import presentation.view.GenerateReportsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GenerateReportsController {
    private DeliveryService deliveryService;
    private GenerateReportsView generateReportsView;
    public GenerateReportsController(GenerateReportsView generateReportsView, DeliveryService deliveryService){
        this.deliveryService = deliveryService;
        this.generateReportsView = generateReportsView;
        this.generateReportsView.addGenerateReport1BttnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int startHour = generateReportsView.getStartHour();
                int endHour = generateReportsView.getEndHour();
                try {
                    deliveryService.generateTimeReport(startHour, endHour);
                    generateReportsView.showError("Report 1 succesfully generated!");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            }
        });
        this.generateReportsView.addGenerateReport2BttnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numberOfTimesOrdered = generateReportsView.getProductsTimesOrdered();
                try {
                    deliveryService.generateFrequencyReport(numberOfTimesOrdered);
                    generateReportsView.showError("Report 2 succesfully generated!");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
        this.generateReportsView.addGenerateReport3BttnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numberOfTimesOrdered = generateReportsView.getClientsTimesOrdered();
                int amount = generateReportsView.getAmount();
                try {
                    deliveryService.generateFrequencyAndValueReport(numberOfTimesOrdered, amount);
                    generateReportsView.showError("Report 3 succesfully generated!");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
        this.generateReportsView.addGenerateReport4BttnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day = generateReportsView.getDay();
                int month = generateReportsView.getMonth();
                int year = generateReportsView.getYear();
                LocalDate date = LocalDate.of(year, month, day);
                try {
                    deliveryService.generateDateReport(date);
                    generateReportsView.showError("Report 4 succesfully generated!");
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            }
        });

    }
}
