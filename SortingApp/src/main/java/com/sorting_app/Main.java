package com.sorting_app;

import com.sorting_app.execution_cycle.ExecutionCycle;
import com.sorting_app.data.DataObject;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        DataObject dataObject = new DataObject();
        ExecutionCycle executionCycle = new ExecutionCycle(dataObject);
        executionCycle.run();

    }
}