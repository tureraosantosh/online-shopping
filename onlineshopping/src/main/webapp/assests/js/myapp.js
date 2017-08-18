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
	
	
	
});