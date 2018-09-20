pipeline {
      agent any


      stages {
         stage('Build') {
            steps {
               sh 'gradle clean compileJava'
               sh './gradlew clean assemble'
            }
         }
         stage('Deploy'){
                    steps{
                        sh 'cf push ord-ordLine-service -p ./build/libs/ord-ordLine-service-0.0.1-SNAPSHOT.jar'
                    }
         }
      }
  }