app.controller('baseController', function ($scope) {


    $scope.reloadList = function () {
        // $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();
        }
    };


    $scope.selectIds = [];
    $scope.updateSelection = function ($event, id) {

        if ($event.target.checked) { // 若是选中
            $scope.selectIds.push(id);
        } else { // 若是取消选中
            // 从数组中删除
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);
        }

    }

    /*
        [{"id":27,"text":"网络"},{"id":32,"text":"机身内存"}]
        "网络","机身内存"
     */
    // jsonString - "[{"id":27,"text":"网络"},{"id":32,"text":"机身内存"}]"
    // key        - 'text'
    $scope.jsonToString = function (jsonString, key) {
        var json = JSON.parse(jsonString);
        var value = "";
        for (var i = 0; i < json.length; i++) {
            if (i > 0) {
                value += ",";
            }
            value += json[i][key];
        }
        return value;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


});