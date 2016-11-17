function examService($http,$interpolate) {
    var userdata = $interpolate('/api/Exam/{{exam_id}}');
    var result = $interpolate('/api/Result');

    return {
        create: create,
        display: display,
        verifyResult: verifyResult
    };


    function create(exam) {
        var data = {
            exam:exam
        };
        return $http.post(userdata(), data);
    }

    function display(exam_id){
        return $http.get(userdata({exam_id:exam_id}))
    }

    function verifyResult(array){

        return $http.post(result(),array);
    }


}
