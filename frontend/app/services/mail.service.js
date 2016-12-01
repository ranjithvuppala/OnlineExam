function mailService($http,$interpolate){
    var mailData = $interpolate('/api/Mail/');
    var ip = "192.168.11.175:8080";
    return{
        sendExam: sendExam,
        sendDetails: sendDetails
    }

    function sendExam(username,id){
        var data={
            to : username,
            subject : "Your Exam from Online Exam Project",
            message : "http://"+ip+"/#/examDisplay?foo="+username+"#"+id
        };
        return $http.post(mailData(),data);
    }

    function sendDetails(username,password){
        var data={
            to : username,
            subject : "Login Details for Online Exam Project",
            message : "Hi you have been selected as Admin for the Online Exam Project.\n your details are :\n Username : " + username + "\n Password : " + password + "\n this is the link to login\n http://"+ip
        };
        return $http.post(mailData(),data)
    }
}