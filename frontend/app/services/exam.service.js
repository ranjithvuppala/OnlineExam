function examService($http,$interpolate) {
    var userdata = $interpolate('/api/Exam/{{exam_id}}');

    return {
        create: create,
        display: display
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


}
