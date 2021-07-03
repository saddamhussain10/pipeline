pipeline{
    agent any
            stages{
                    stage('One'){
                        steps{
                               echo' Hi from saddam'
                        }
                    }
                    stage('Two'){
                        steps{
                               input(do you want to proceed?')
                        }
                    }
                    stage('Three'){
                        when{ 
                            not{
                                branch "master"
                            }
                            }
                        steps{
                            echo 'hello'
                        }    
                    }
                    stage('Four'){
                        parallel{
                    stage('Unit Test') {
                        steps {
                               echo "RUNNING THE UNIT TEST ......"
                        }
                    } 
                    stage('Integration Test'){
                        agent{
                              docker{
                                      reuseNode false
                                      image'ubuntu'
                              }
                        }
                        steps{
                              echo "RUNNING THE INTEGRATION TEST....."
                        }
                    }      
                        }
                    }

            }
}