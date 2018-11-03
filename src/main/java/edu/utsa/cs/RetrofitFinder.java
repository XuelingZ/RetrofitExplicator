package edu.utsa.cs;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.AnnotationTag;
import soot.tagkit.Tag;
import soot.tagkit.VisibilityAnnotationTag;

import java.util.Map;

public class RetrofitFinder extends soot.SceneTransformer{

    public RetrofitFinder(){
        System.out.println("RetrofitFinder created");
    }

    protected void internalTransform(String s, Map<String, String> map) {
        System.out.println("RetrofitFinder called");
        for(SootClass klass : Scene.v().getApplicationClasses()){
            for(SootMethod method : klass.getMethods()){
                if(method.hasActiveBody()){
                    System.out.println("Active body: "+method.getName());
                    System.out.println("   has "+method.getTags().size()+" tags.");
                    for(Tag tag : method.getTags()){
                        //System.out.println("  "+tag.getName()+" : "+tag.getValue());
                        System.out.println("  "+tag.getName());
                    }
                } else {
                    System.out.println("**** Inactive body: "+method.getName());
                    System.out.println("   has "+method.getTags().size()+" tags.");
                    for(Tag tag : method.getTags()){
                        System.out.println("  "+tag.getName());
                        if(tag instanceof VisibilityAnnotationTag){
                            VisibilityAnnotationTag vat = (VisibilityAnnotationTag)tag;
                            for(AnnotationTag annotation : vat.getAnnotations()){
                                System.out.println("  annotation: "+annotation);
                            }
                        }
                        //System.out.println("  "+tag.getName()+" : "+tag.getValue());
                        //try{
                            //System.out.println("    "+tag);
                            //System.out.println("    "+tag.getValue());
                        //} catch (Exception ex) {
                            //System.out.println(ex);
                        //}
                    }
                }
            }
        }
    }
}
