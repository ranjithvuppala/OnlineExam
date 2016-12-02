function examService($http,$interpolate) {
    var userdata = $interpolate('/api/Exam/{{exam_id}}');
    var result = $interpolate('/api/Result');
    var userexam = $interpolate('/api/userExam/{{Id}}');
    var user = $interpolate('/api/userExam/user/{{userId}}');

    return {
        create: create,
        display: display,
        verifyResult: verifyResult,
        findExambyId: findExambyId,
        resultUpdate: resultUpdate,
        examList: examList,
        examListAssignedToUser: examListAssignedToUser,
        assignExamToUser: assignExamToUser,
        examResponseList: examResponseList
    };


    function create(exam) {
        var data = {
            exam:exam
        };
        return $http.post(userdata(), data);
    }

    function examList(){
        return $http.get(userdata());
    }

    function examListAssignedToUser(userId){
        return $http.get(user({userId:userId}))
    }

    function display(exam_id){
        return $http.get(userdata({exam_id:exam_id}))
    }

    function verifyResult(array){

        return $http.post(result(),array);
    }

    function findExambyId(id){

        return $http.get(userexam({Id:id}));
    }

    function resultUpdate(score){
        return $http.post("/api/userExam/result",score);
    }

    function assignExamToUser(data){
        return $http.post(userexam(),data);
    }

    function examResponseList(){
        return $http.get(userdata()+"all");
    }


}
