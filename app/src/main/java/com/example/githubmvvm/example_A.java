package com.example.githubmvvm;

public class example_A {

    private String abc="";
    private void repeatcode1() {
        LogCalls_Debug.INSTANCE.d(LogCalls_Debug.TAG, "");
    }
  //GitHubMvvM Token=  sqp_6675f093749679d1113ac3c51340efede3b225f6
// sonar io cloud= 13bfa39da85cf692fc80c5e270891bafb1d96d82
//    ./gradlew sonarqube - Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_6675f093749679d1113ac3c51340efede3b225f6
//        ./gradlew sonarqube -D "sonar.projectKey=GitHubMvvM1" -D "sonar.host.url=http://localhost:9000" -D "sonar.login=sqp_6675f093749679d1113ac3c51340efede3b225f6"

    //./gradlew sonarqube -D "sonar.projectKey=abduljalilkhan_first_khan" -D "sonar.host.url=https://sonarcloud.io" -D "sonar.login=13bfa39da85cf692fc80c5e270891bafb1d96d82"


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
        repeatcode2();
        repeatcode2();
    }
}
