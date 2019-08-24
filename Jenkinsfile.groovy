node {
    stage("Pull Repo"){
        properties([parameters([string(defaultValue: '34.254.184.223', description: '''Dev:34.254.184.223 Qa:52.213.196.101 Prod:63.33.45.101''', name: 'Remote_Instance', trim: false)])])
         git 'git https://github.com/Madina89/Jenkins_Infra.git'
    }
    stage("Install Apache"){
        sh "ssh ec2-user@${Remote_instances} sudo yum install httpd -y"
    }
}
    


       
