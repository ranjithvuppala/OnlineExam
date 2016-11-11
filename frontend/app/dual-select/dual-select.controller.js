function DualSelectController(arrayofObjects) {

    var vm = this;

    vm.$onInit = $onInit;
    vm.transfer = transfer;
    vm.onSubmit = onSubmit;


    function $onInit() {
        vm.left = arrayofObjects;
        vm.right = [];
    }

    function transfer(selected, from, to) {

        var n = selected.length;
        for (i = 0; i < n; i++) {
            var k = arrayObjectIndexOf(from, selected[i]);
            to.push(selected[i]);
            from.splice(k, 1);
        }

        to.sort(function (a, b) {
            return a.id - b.id;
        });
    }

    function arrayObjectIndexOf(Array, searchTerm) {
        for (var i = 0, len = Array.length; i < len; i++) {
            if (Array[i].id === searchTerm.id) return i;
        }
        return -1;
    }


    function onSubmit(array) {
       arrayofSelectedObjects = array;
    }

    return arrayofSelectedObjects;
}
