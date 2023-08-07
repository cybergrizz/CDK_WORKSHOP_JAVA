package com.myorg;

import io.github.cdklabs.dynamotableviewer.TableViewer;

import software.constructs.Construct;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;

import software.amazon.awscdk.services.apigateway.LambdaRestApi;
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
            .runtime(Runtime.NODEJS_18_X)
            .code(Code.fromAsset("lambda"))
            .handler("hello.handler")
            .build();

        final HitCounter helloWithCounter = new HitCounter(this, "HelloHitCounter", HitCounterProps.builder()
            .downstream(hello)
            .build());

        LambdaRestApi.Builder.create(this, "Endpoint")
            .handler(hello)
            .build();
        
        TableViewer.Builder.create(this, "ViewerHitCount")
            .title("Hello Hits")
            .table(helloWithCounter.getTable())
            .build();

    }
}
