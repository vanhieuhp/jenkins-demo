node('slave1') {
    try {
        def tagName
        env.APPFILE = 'hello-gradle'
    stage('hello') {
        echo "hello slack"
    }
    stage("source") {
        git branch: 'gradle', url: 'https://github.com/vanhieuhp/jenkins-demo.git'
    }
    stage("test") {
        sh "./gradlew test"
    }
    // stage("build") {
    //     sh "./gradlew bootJar"
    // }
    // stage("archive") {
    //     archiveArtifacts artifacts: 'build/libs/**/*.jar'
    // }
    stage('input-image-tag') {
        def tag = input id: 'ctns-prompt', message:'Input your tag image!',
        parameters: [string(defaultValue: '', description: '',
        name: 'tagName')], submitterParameter: 'user'
        tagName = tag['tagName']
    }
    stage("build images") {
        sh "./gradlew bootBuildImage --imageName='$env.APPFILE:$tagName'"
    }
    stage("build container") {
        echo "imageName: $tagName"
        sh "docker run -d --name hello-gradle --rm -p 8080:8080 $env.APPFILE:$tagName"
    }
    }
    catch(err) {
        currentBuild.result = 'FAILURE'
    } finally{
        stage('sendslack') {
        slackSend channel: '#jenkins-notification', 
        color: 'good', 
        message: "Resutl Build: ${currentBuild.currentResult}", 
        tokenCredentialId: 'jenkins-test-slack'
    }
    }
    
    
    
}