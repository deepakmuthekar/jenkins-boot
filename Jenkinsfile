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
        
      
      
    }
}
