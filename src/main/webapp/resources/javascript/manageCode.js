onload = function(){
    $(function(){
    	$('#hideBtn').click(
			function(){
				$this=$(this);
				$fileName = $this.parents('tr').children('td').eq(0).text();
				
				$hide = $this.text();
				if($hide=="공개"){
					$hide=true; //감춤
				}else if($hide=="비공개"){
					$hide=false; //공개
				}
				$.ajax({
	                  type:"GET",
	                  url: "hideFile.do",
	                  data: "fileName="+$fileName+"&hide="+$hide,
	                  datatype:"json", 
	                  success: function(data) {
	                	  $hide = $this.text();
	                	  if($hide=='공개'){
	      					$this.text('비공개');
	      				  }else if($hide=='비공개'){
	      					$this.text('공개');
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
    	$('#deleteBtn').click(
			function(){
				var result = confirm("코드를 삭제하시겠습니까?");
				 if(result){
					 $this=$(this);
						$fileName = $this.parents('tr').children('td').eq(0).text();
						
						$form = $("form"); 
						$form.attr('method','get');
						$form.attr('action','deleteFile.do');
						
						$child = "<input type='hidden' name='fileName' value="+$fileName+'>';
						$form.append($child); 
						$form.submit();
				 }else{
					 
				 }
			});
    });
}

