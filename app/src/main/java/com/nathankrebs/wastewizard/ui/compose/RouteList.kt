package com.nathankrebs.wastewizard.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nathankrebs.wastewizard.R
import com.nathankrebs.wastewizard.model.RouteItem
import com.nathankrebs.wastewizard.ui.theme.listItemPadding

@Composable
fun RouteList(
    routes: List<RouteItem>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier) {
        items(routes, key = { it.id }) { routeItem ->
            RouteListItem(
                modifier = Modifier.fillMaxWidth(),
                routeItem = routeItem,
            )
            Divider()
        }
    }
}

@Composable
fun RouteListItem(
    routeItem: RouteItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(listItemPadding),
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Text(
            text = routeItem.name,
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = stringResource(R.string.route_list_type_label, routeItem.type),
            style = MaterialTheme.typography.overline,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DriverRouteScreenPreview() {
    RouteList(
        routes = listOf(
            RouteItem(1, "Type 1", "Route 1"),
            RouteItem(1, "Type 1", "Route 2"),
            RouteItem(1, "Type 1", "Route 3"),
            RouteItem(1, "Type 1", "Route 4"),
            RouteItem(1, "Type 1", "Route 45"),
        )
    )
}
