package com.example.githubmvvm;

public class example_A {
    private void repeatcode1() {
        LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG, "");
    }

    public void repeatcode2(){
        LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG,"");
        LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG,"");
        Boolean condition=true;
        if (condition){
            LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG,"do nothing");
        }
        else{
            LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG,"do nothing");
        }
        repeatcode2();
    }
}
