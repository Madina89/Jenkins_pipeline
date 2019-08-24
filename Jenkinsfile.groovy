node {
    stage("Say Hello"){
        properties([parameters([string(defaultValue: '34.254.184.223', description: '''Dev:34.254.184.223 Qa:52.213.196.101 Prod:63.33.45.101''', name: 'Remote_Instance', trim: false)])])
         git 'https://github.com/Madina89/jenkinsapril.git'
    }
}
    


       
