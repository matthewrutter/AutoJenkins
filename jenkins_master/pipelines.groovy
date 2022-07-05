pipelineJob('dockertests') {
    environmentVariables {
        env('DISCORD', "${DISCORD_WEBHOOK}")
    }
    configure { it / 'triggers' / 'com.cloudbees.jenkins.GitHubPushTrigger' / 'spec' }
    definition {
        cpsScm {
            scm {
                git {
                    remote { 
                        url("${GITHUB_REPO}") 
                        credentials('ssh_private_key')
                    }
                    scriptPath('Jenkinsfile')
                    
                }
            }
        }
    }
}

// pipelineJob('dockertests') {
//     configure { it / 'triggers' / 'com.cloudbees.jenkins.GitHubPushTrigger' / 'spec' }
//     definition {
//         cps {
//             script('''
//                 pipeline {
//                     agent {
//                         docker { image 'node:16.13.1-alpine' }
//                     }
//                     stages {
//                         stage('Test') {
//                             steps {
//                                 sh 'node --version'
//                             }
//                         }
//                     }

//                     // Post-build actions
//                     post {
//                         always {
                            
//                             slackSend channel: '#general',
//                             message: "*${currentBuild.currentResult}:* Job ${env.JOB_NAME} build ${env.BUILD_NUMBER} More info at: ${env.BUILD_URL}"
//                         }
                       
//                     }
//                 }
//             ''')
//             sandbox()
//         }
//     }
// }

