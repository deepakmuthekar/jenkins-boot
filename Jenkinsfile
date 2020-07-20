pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        gradle "gradle"
        jdk "Java-14"
    }

    stages {
        stage('Build') {
            steps('Checkout Code') {
                git 'https://github.com/deepakmuthekar/jenkins-boot.git'
	         }
	         
	         steps('Build Code') {
                sh "gradle clean build"
	         }
			
            post {
                success {
                    echo 'Everything done...'  
                }
            }
        }
        
        stage('Sonarqube analysis'){
            
            steps('Analysis'){
                withSonarQubeEnv('sonar') {
                 sh 'gradle sonarqube'
              }    
            }
            
            steps("Quality Gate"){
          	  timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }        

        }

        
      
      
    }
}
