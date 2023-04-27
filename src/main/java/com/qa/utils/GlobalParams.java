package com.qa.utils;

import net.bytebuddy.implementation.bytecode.Throw;

public class GlobalParams {

    private static ThreadLocal<String> platformName = new ThreadLocal<>();
    private static ThreadLocal<String> udid = new ThreadLocal<>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<>();

    /////////////////////Set-Get Methods for Thread Local Variables////////////////////////////////
    public void setPlatformName(String platformName1){
        platformName.set(platformName1);
    }

    public String getPlatformName(){
        return platformName.get();
    }

    public void setUDID(String udid1){
        udid.set(udid1);
    }

    public String getUDID(){
        return udid.get();
    }

    public void setDeviceName(String deviceName1){
        deviceName.set(deviceName1);
    }

    public String getDeviceName(){
        return deviceName.get();
    }

    public void setSystemPort(String systemPort1){
        systemPort.set(systemPort1);
    }

    public String getSystemPort(){
        return systemPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort1){
        chromeDriverPort.set(chromeDriverPort1);
    }

    public String getChromeDriverPort(){
        return chromeDriverPort.get();
    }

    public void setWdaLocalPort(String wdaLocalPort1){
        wdaLocalPort.set(wdaLocalPort1);
    }

    public String getWdaLocalPort(){
        return wdaLocalPort.get();
    }

    public void setWebkitDebugProxyPort(String webkitDebugProxyPort1){
        webkitDebugProxyPort.set(webkitDebugProxyPort1);
    }

    public String getWebkitDebugProxyPort(){
        return webkitDebugProxyPort.get();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////

    public void initializeGlobalParams(){
        GlobalParams params = new GlobalParams();
        params.setPlatformName(System.getProperty("platformName", "Android"));
        params.setUDID(System.getProperty("udid", "DAMGI521UC00033"));
        params.setDeviceName(System.getProperty("deviceName", "Pixel_2"));

        switch (params.getPlatformName()){

            case "Android":
                params.setSystemPort(System.getProperty("systemPort", "10000"));
                params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
                break;

            case "iOS":
                params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
                params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "10001"));
                break;

            default:
                throw new IllegalStateException("Invalid platform Name");
        }
    }
}
