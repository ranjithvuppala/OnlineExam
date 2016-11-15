function questionChoiceService($http,$interpolate){
    var questionChoice = $interpolate('/api/QuestionChoice/{{question_id}}');

    return {
        list: list,
        create: create
    };

    function list(question_id) {
        return $http.get(questionChoice({question_id: question_id}));
    }

    function create(array) {
        return $http.post(questionChoice(), array);
    }
}
