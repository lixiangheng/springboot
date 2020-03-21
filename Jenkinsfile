pipeline {
   agent any
    parameters {
  gitParameter branch: '', branchFilter: '.*', defaultValue: 'origin/master', description: '选择要更新的版本', listSize: '10', name: 'choice', quickFilterEnabled: true, selectedValue: 'NONE', sortMode: 'DESCENDING_SMART', tagFilter: '*', type: 'PT_TAG'
}
   stages {
      stage('scm') {
         steps {
            // SCM
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '532e6bbf-90ac-4565-9860-265e214b76ff', name: 'origin', url: 'git@gitee.com:UNFEE1ING/java_web.git']]])
            sh label: '', script: '[ -n ${choice} ] && git checkout ${choice} || echo -n'
         }
      }
      stage('Maven Build') {
            steps {
              // mvn build
            sh label: '', script: '/opt/apache-maven-3.6.3/bin/mvn -Dmaven.test.failure.ignore=true clean package'
            }
      }
      
      stage('publisher to server') {
          steps {
              sshPublisher(publishers: [sshPublisherDesc(configName: '10.20.100.12', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '''SERVICE_NAME=/opt/hello/hello-0.0.1-SNAPSHOT.jar
PID=`ps -ef |grep $SERVICE_NAME |grep -v grep |awk \'{print $2}\'`
if [ -z $PID ];then
nohup /usr/bin/java -jar $SERVICE_NAME >> nohup\\.out 2>&1 &
else
       /bin/kill -9 $PID
nohup /usr/bin/java -jar $SERVICE_NAME >> nohup\\.out 2>&1 &
fi''', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: 'target/', sourceFiles: 'target/*.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
          }
      }

   }
   post {
            success {
               echo 'chenggong'
            sh label: '', script: '''git config user.email "hn.lxh@qq.com"
git config user.name "Seven"
git tag ${choice}_${BUILD_TIMESTAMP}
git push origin ${choice}_${BUILD_TIMESTAMP}'''
          
    }
            
    }
}