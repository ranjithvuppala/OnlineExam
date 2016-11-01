function questionService($http, $interpolate) {
    var question = $interpolate('/api/QuestionPaper/{{question_id}}');

    return {
        list: list,
        create: create,
        destroy: destroy,
        update: update
    };

    function list() {
        return $http.get(question());
    }

    function create(quest, firstoption,secondoption,thirdoption,fourthoption,correctoption) {
        var data = {
            quest: quest,
            firstoption: firstoption,
            secondoption: secondoption,
            thirdoption: thirdoption,
            fourthoption: fourthoption,
            correctoption: correctoption
        };

        return $http.post(question(), data);
    }

    function destroy(id) {
        return $http.delete(note({ question_id: id }));
    }

    function update(id,quest,firstoption,secondoption,thirdoption,fourthoption,correctoption) {
        var data = {
            quest: quest,
            firstoption: firstoption,
            secondoption: secondoption,
            thirdoption: thirdoption,
            fourthoption: fourthoption,
            correctoption: correctoption
        };

        return $http.put(note({ question_id: id }), data);
    }
}
