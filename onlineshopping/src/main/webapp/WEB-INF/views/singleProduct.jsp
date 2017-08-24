

<div class="container">

	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-xs-12">

			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>


			</ol>
		</div>

	</div>
</div>

<div class="row">

	<!-- images display  -->
	<div class="col-sx-12 col-sm-4">

		<div class="thumbnail">
			<img alt=" " src="${images}/${product.code}.jpg"
				class="img img-responsive">
		</div>

	</div>

	<!-- Product Description display  -->
	<div class="col-sx-12 col-sm-8">
		<h3>${product.name}</h3>
		<hr>
		<p>${product.description}</p>
		<hr />

		<h4>
			Price : <strong>&#8377; ${product.unitPrice} /-</strong>
		</h4>
		<hr />


		<c:choose>
			<c:when test="${product.quantity<1 }">
				<h6>
					Qty Avl :  <span style="color:red">out of stock</span>
				</h6>

			</c:when>
			<c:otherwise>
				<h6>Qty Avl: ${product.quantity }</h6>
			</c:otherwise>

		</c:choose>



		<c:choose>
			<c:when test="${product.quantity<1 }">
				<h6>
					<a href="javascript:void(0)"
			class="btn btn-danger btn-disabled"><strike> <span
				class="glyphicon glyphicon-shopping-cart">
			</span>Add to Cart</strike></a>
				</h6>

			</c:when>
			<c:otherwise>
				<a href="${contextRoot}/cart/add/${product.id}/product"
			class="btn btn-success"><span
				class="glyphicon glyphicon-shopping-cart">
			</span>Add to Cart</a>
			</c:otherwise>

		</c:choose>
		 <a href="${contextRoot}/show/all/products"class="btn btn-primary"><span class="glyphicon glyphicon-shopping-cart"></span>Back</a>

	</div>
</div>