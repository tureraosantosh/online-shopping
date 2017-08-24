$(function(){
	switch(menu)
	{
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Home':
		$('#home').addClass('active');
		break;
	case 'All Products':
		$('#products').addClass('active');
		break;
		
		default:
		
			$('#products').addClass('active');
			$('a_'+menu).addClass('active');
			break;
		
	}
	
	/*
	 * this is dummy data so not in use now commiting it..
	 * var products=[
	              ['1','santosh'],
	              ['2','sanjay'],
	              ['3','ajay'],
	              ['4','vijay'],
	              ['5','kumar'],
	              ['6','vishal'],
	              ['7','sagar'],
	              ['8','vinay'],
	              ['9','sujay'],
	              ['10','vilas'],
	              ['11','viswal']
	           
	              
	              
	              
	              
	              ];
	*/
	$table=$('#productListTable');
	//execute the bellow code only  where we have this table
	if($table.length)
		{
		//console.log("this is inside "); 
		
		var jsonUrl='';
		
		if(window.categoryid=='')
			{
			jsonUrl=window.contextRoot+'/json/data/all/products';
			}
		else
			{
			jsonUrl=window.contextRoot+'/json/data/category/'+3+'/products';
			}
		$table.DataTable(
		{
			lengthMenu:[[3,5,10,-1],['3 products','5 products ','10 products ','All Products ']],
			pageLength:5,
			//data:products
			
			ajax:
				{
				
				url:jsonUrl,
				dataSrc:''
				},
				
				columns:
					[
					 {
						data:'code',
						mRender:function(data,row,row)
						{
							return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
						}
						 
					 },
					 {
						 
						 data :'name'
						 
					 },
{
						 
						 data :'brand'
						 
					 },
{
						 
						 data :'unitPrice',
							 mRender:function(data,type,row)
							 {
								 return '&#8377; '+data
								 
							 }
						 
					 },
					 
					 {
						 
						 data :'quantity',
						 mRender:function(data,type,row)
						 {
							 if(data<1)
								 {
								 
								 return '<span style="color:red"> out of stock <span/>';
								 }
							 return data;
						 }
						 
					 },
					 {
						 data:'id',
						 bSortable:false,
						 mRender:function(data,type,row)
						 {
							 var str='';
							 str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"/><span class="glyphicon glyphicon-eye-open"></span></a>&#160;';
							
							 if(row.quantity<1)
								 {
								 str+='<a href="javascript:void(0)" class="btn btn-success disabled"/><span class="glyphicon glyphicon-shopping-cart"></span> </a>';
								 }
							 else
								 {
								 
							 str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"/><span class="glyphicon glyphicon-shopping-cart"></span> </a>';
							
								 }
							 return str;
						 }
					 }
					 
					 
					 ]
		}		
		);
		}
	
});