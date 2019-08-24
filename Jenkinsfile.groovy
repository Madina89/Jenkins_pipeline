node {
    stage("Pull Repo"){
        properties([parameters([string(defaultValue: '34.254.184.223', description: '''Dev:34.254.184.223 Qa:52.213.196.101 Prod:63.33.45.101''', name: 'Remote_Instance', trim: false)])])
         git 'git https://github.com/Madina89/Jenkins_Infra.git'
    }
    stage("Install Apache"){
        sh "ssh ec2-user@${Remote_instances} sudo yum install httpd -y"
    }
    stage("Create index.html"){
        sh "scp index.html ec2-user@${Remote_instances}:/tmp"

    }
    stage("Move Files"){
        sh " ssh ec2-user@${Remote_instances} sudo mv /tmp/index.html   /var/www/html/index.html"
    }
    stage("Restart httpd"){
        sh "ssh ec2-user@${Remote_insyances} sudo systemctl restart httpd"
    }
}
    


       
