<div class="container">
	<div class="row">
		<!-- side bar will display here which display category menu -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>

		<!-- This will Display Table of Product -->
		<div class="col-md-9">
			<!-- added the breadcrumb class -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts}">

						<script>
							window.categoryId = '';
						</script>

						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All products</li>
						</ol>
					</c:if>

					<c:if test="${userClickCategoryProducts}">

						<script>
							window.categoryId = '${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category products</li>
							<li class="active">${category.name}</li>


						</ol>
					</c:if>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-12">

					<table id="productListTable"
						class="table table-striped table-border">

						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Unit Price</th>
								<th>Qty. Available</th>
								<th></th>
							</tr>

						</thead>

						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>Unit Price</th>
								<th>Qty. Available</th>
								<th></th>


							</tr>

						</tfoot>

					</table>
				</div>
			</div>
		</div>

	</div>

</div>