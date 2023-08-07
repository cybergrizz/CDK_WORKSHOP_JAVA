package com.myorg;

import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;

public class CdkWorkshopJava2Stack extends Stack {
    public CdkWorkshopJava2Stack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public CdkWorkshopJava2Stack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);

        final Function hello = Function.Builder.create(this, "HelloHandler")
        .runtime(Runtime.NODEJS_14_X)
        .code(Code.fromAsset("lambda"))
        .handler("hello.handler")
        .build();

    }
}
