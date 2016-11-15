function examQuestionService($http,$interpolate){
    var userdata = $interpolate('/api/ExamQuestion/');

    return {
        create: create
    };


    function create(data) {
        return $http.post(userdata(), data);
    }

}