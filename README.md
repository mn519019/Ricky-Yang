# Ricky-Yang

<html>
<head>
<title>Ricky Yang</title>
</head>
<script>

function answer(){
var firstInput = document.getElementById("F1");
var first = Number(firstInput.value);

var secondInput = document.getElementById("F2");
var second= Number(secondInput.value);

var thirdInput = document.getElementById("F3");
var thrid = Number(thirdInput.value);


var sum =first+second+thrid;
var sumSpan = document.getElementById("result");
sumSpan.innerHTML="The sum is "+sum+".";

}

</script>

<body>

<input type="text" id="F1">
<span>+</span>
<input type="text" id="F2">
<span>+</span>
<input type="text" id="F3">
<button onclick="answer()">=</button>
<br /><br />
<span id="result"></span>



</body>


</body>
</html>
