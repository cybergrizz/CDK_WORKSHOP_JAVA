package com.myorg;

import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

public class CdkWorkshopJava2Stack extends Stack {
    public CdkWorkshopJava2Stack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public CdkWorkshopJava2Stack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

    }
}
