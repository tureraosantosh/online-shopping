<div class="container">
	<div class="row">

		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>

		</div>
		<div class="col-md-9">
			<!-- added the breadcrumb class -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts}">
						<ol class="breadcrumb">
							<li><a href="/onlineshopping/home">Home</a></li>
							<li class="active">All products</li>


						</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts}">
						<ol class="breadcrumb">
							<li><a href="/onlineshopping/home">Home</a></li>
							<li class="active">Category products</li>
							<li class="active">${category.name}</li>


						</ol>
					</c:if>
				</div>
			</div>

		</div>

	</div>

</div>