/*
 * Copyright (c) Microsoft. All rights reserved.
 * Licensed under the MIT license. See LICENSE file in the project root for full license information.
 */
package com.microsoft.azure.eventhubs.sendrecv;

import com.microsoft.azure.eventhubs.EventHubException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.microsoft.azure.eventhubs.lib.SasTokenTestBase;
import com.microsoft.azure.eventhubs.lib.TestContext;

public class SasTokenReceiveTest extends SasTokenTestBase {
    
    private static ReceiveTest receiveTest;
    
    @BeforeClass
    public static void initialize()  throws Exception {
        
        Assert.assertTrue(TestContext.getConnectionString().getSharedAccessSignature() != null
                            && TestContext.getConnectionString().getSasKey() == null
                            && TestContext.getConnectionString().getSasKeyName() == null);
        
        receiveTest = new ReceiveTest();
        ReceiveTest.initializeEventHub();
    }
    
    @Test()
    public void testReceiverStartOfStreamFilters() throws EventHubException {
        
        receiveTest.testReceiverStartOfStreamFilters();
    }
    
    @After
    public void testCleanup() throws EventHubException {
        
        receiveTest.testCleanup();
    }
    
    @AfterClass()
    public static void cleanup() throws EventHubException {
        
        ReceiveTest.cleanup();
    }
}
