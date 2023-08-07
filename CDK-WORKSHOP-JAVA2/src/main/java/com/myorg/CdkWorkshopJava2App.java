package com.myorg;

import software.amazon.awscdk.App;

public final class CdkWorkshopJava2App {
    public static void main(final String[] args) {
        App app = new App();

        new CdkWorkshopJava2Stack(app, "CdkWorkshopJava2Stack");

        app.synth();
    }
}
