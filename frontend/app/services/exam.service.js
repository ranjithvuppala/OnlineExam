function examService($http,$interpolate) {
    var userdata = $interpolate('/api/Exam/{{exam_id}}');

    return {
        create: create
    };


    function create(exam) {
        var data = {
            exam:exam
        }
        return $http.post(userdata(), data);
    }


}
