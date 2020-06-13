onload = function(){
    $(function(){
    	$('#searchCodeBtn').click(
			function(){
				$this=$(this);
				
				$select = $this.siblings('select');
						
				$('#searchTxt').attr('name' , $select.val());
				
				$this.parents('form').submit();
			});
    });
}

