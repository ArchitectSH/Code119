onload = function(){
	var editor = ace.edit("editor");
    editor.setTheme("ace/theme/iplastic");
    editor.session.setMode("ace/mode/java");


$(function(){
	$('#joinBtn').click(
		function(){
			$email = $('#email').val();
			$regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
			
			if($regex.test($email) === false) {  
			    alert("잘못된 이메일 형식입니다.");  
			    return false;  
			} else {  
				$('#loginForm').attr("action","join.do");
				$('#loginForm').submit();
			}
		});
});

$(function(){
	$('#loginBtn').click(
		function(){
			$email = $('#email').val();
			$regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;   
			  
			if($regex.test($email) === false) {  
			    alert("잘못된 이메일 형식입니다.");  
			    return false;  
			} else {  
				$('#loginForm').attr("action","login.do");
				$('#loginForm').submit();
			}
		});
});

$(function(){
	$('#runBtn').click(
		function(){
			$code = editor.getValue();
			$input = $('#inputTxt').val();
			$('#fileNameTxt2').val($('#fileNameTxt1').val());
			var fileName = $('#fileNameTxt1').val();
			if(!(fileName[fileName.length-5]=='.' && fileName[fileName.length-4]=='j'
				&& fileName[fileName.length-3]=='a' && fileName[fileName.length-2]=='v'
				&& fileName[fileName.length-1]=='a')){
				alert('파일명은 *.java 여야 합니다.');
				return ;
			}
			$.ajax({
                  type:"POST",
                  url: "run.do",
                  data: "fileName="+$('#fileNameTxt2').val()+"&contents="+$code+"&input="+$input,
                  datatype:"json", 
                  success: function(data) {
            		  if(data.originCompileErr==null){
            			  if(data.originRunErr==null){
            				$('#resultTxt').text(data.result);
            			  }else{
            				var contents = "\n - 런타임 에러 -\n\n"+data.originRunErr+"\n  <에러 번역>\n\n"+data.transRunErr;
            				$('#resultTxt').text(contents);
            			  }
            		  }else{
            			 var contents = "\n - 컴파일 에러 -\n\n"+data.originCompileErr+"\n  <에러 번역>\n\n"+data.transCompileErr;
            			 $('#resultTxt').text(contents);
            		  }
                  },
                  error: function(e) {
                     console.log(e);
                     alert("에러발생");
                  }         
               });
		});
});

$(function(){
	$('#saveCodeBtn').click(
		function(){
			var fileName = $('#fileNameTxt1').val();
			if(!(fileName[fileName.length-5]=='.' && fileName[fileName.length-4]=='j'
				&& fileName[fileName.length-3]=='a' && fileName[fileName.length-2]=='v'
				&& fileName[fileName.length-1]=='a')){
				alert('파일명은 *.java 여야 합니다.');
				return ;
			}
			var code = editor.getValue();
			$.ajax({
                  type:"POST",
                  url: "save.do",
                  data: "fileName="+fileName+"&contents="+code,
                  datatype:"json", 
                  success: function(data) {
                	  if(data=='-1'){
                		  alert('로그인해주세요.');
                	  }else if(data=="already"){
                		  var result = confirm("같은 이름의 파일이 이미 있습니다. 파일을 덮어 씌우시겠습니까?");
                		  if(result){
                			  $.ajax({
            	                  type:"POST",
            	                  url: "save.do",
            	                  data: "fileName="+fileName+"&contents="+code+"&overWrite=true",
            	                  datatype:"json", 
            	                  success: function(data) {
            	                	  if(data=='-1'){
            	                		  alert('로그인해주세요.');
            	                	  }else{
            	                		  alert('정상적으로 저장되었습니다.');  
            	                	  }
            	                  },
            	                  error: function(e) {
            	                     console.log(e);
            	                     alert("에러발생");
            	                  }         
            	               });
                		  }
                	  }else{
                		  alert('정상적으로 저장되었습니다.');  
                	  }
                  },
                  error: function(e) {
                     console.log(e);
                     alert("에러발생");
                  }         
               });
		});
});


$(function(){
	$('#fileNameTxt1').on("change",
		function(){
			$('#fileNameTxt2').val($('#fileNameTxt1').val());
		});
});

}
