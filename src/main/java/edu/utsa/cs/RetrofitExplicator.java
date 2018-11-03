package edu.utsa.cs;

import soot.*;

import java.util.Map;

public class RetrofitExplicator {
    public static void main(String[] args) {
        System.out.println("Hello, New Soot.");

// Inject the analysis into Soot
        PackManager.v().getPack("wjtp").add(new
        Transform("wjtp.rf", new RetrofitFinder()));
        PackManager.v().getPack("wjtp").add(
                new Transform("wjtp.myTransform", new SceneTransformer() {
                    protected void internalTransform(String phaseName,
                                                     Map options) {
                        System.err.println(Scene.v().getApplicationClasses());
                    }
                }));
// Invoke soot.RetrofitExplicator with arguments given

        for(String arg : args){
            System.out.println("Arg: "+arg);
        }
        Main.main(args);
        //PackManager.v().getPack("wjtp").apply();
    }
}
