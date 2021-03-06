#!/usr/bin/env groovy

import com.jdcloud.*
import hudson.model.*

def call(def env){

    def fromYaml = new FromYaml(env,this)
    def scriptPath = fromYaml.GenerateShellScript()
    def requirements = fromYaml.DefineRequirements()
    env.OutputSpace = fromYaml.getOutputSpace()

    dir(env.UserWorkSpace){
        withDockerContainer(args: requirements ,image:env.BUILD_IMAGE) {
            def s = sh(returnStatus:true ,script:scriptPath)
            if(s != 0){
                error("Failed in executing commands, exiting..")
            }
        }
    }
}