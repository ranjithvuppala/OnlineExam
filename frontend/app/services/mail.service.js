function mailService($http,$interpolate){
    var mailData = $interpolate('/api/Mail/');

    return{
        sendExam: sendExam,
        sendDetails: sendDetails
    }

    function sendExam(){
        return null;
    }

    function sendDetails(username,password){
        var data={
            to : username,
            subject : "Login Details for Online Exam Project",
            message : "Hi you have been selected as Admin for the Online Exam Project.\n your details are :\n Username : " + username + "\n Password : " + password
        };
        return $http.post(mailData(),data)
    }
}