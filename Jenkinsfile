pipeline {
    agent any

    tools {
        gradle "gradle"
        jdk "Java-14"
    }

    stages {
        stage('Build') {
            steps('Checkout Code') {
                git 'https://github.com/deepakmuthekar/jenkins-boot.git'
                
				sh 'gradle clean build'
	         }
        }
        
        stage('Sonarqube analysis') {
            
            steps {
                withSonarQubeEnv('sonar') {
                 sh 'gradle sonarqube'
              }    
           }
        }
        
        stage('Quality Gate') {
        	steps {
            	timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
            }       
        }


    }
}
