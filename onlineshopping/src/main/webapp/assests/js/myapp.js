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
		default:
		
			$('#home').addClass('active');
			break;
		
	}
	
	
	
});