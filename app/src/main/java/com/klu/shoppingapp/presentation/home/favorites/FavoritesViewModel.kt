package com.klu.shoppingapp.presentation.home.favorites

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.klu.shoppingapp.R
import com.klu.shoppingapp.common.Response
import com.klu.shoppingapp.common.helpers.UiText
import com.klu.shoppingapp.domain.repository.ShoppingRepository
import com.klu.shoppingapp.model.shopping.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@Stable
@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val shoppingRepository: ShoppingRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> = _uiState.asStateFlow()

    fun getAllFavoriteProducts() {
        viewModelScope.launch(ioDispatcher) {
            _uiState.update { it.copy(isLoading = true) }
            when (val response = shoppingRepository.getAllFavoriteProducts()) {
                is Response.Success -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            favoriteList = response.data
                        )
                    }
                }

                is Response.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            userMessages = listOf(
                                UiText.StringResource(resId = response.errorMessageId)
                            )
                        )
                    }
                }
            }
        }
    }

    fun removeProductFromFavorites(productId: Int?) {
        productId?.let {
            viewModelScope.launch(ioDispatcher) {
                when (val response = shoppingRepository.removeFavoriteProduct(productId)) {
                    is Response.Success -> {
                        val currentList = _uiState.value.favoriteList.toMutableList()
                        currentList.removeIf {
                            it.id == productId
                        }

                        _uiState.update {
                            it.copy(
                                userMessages = listOf(
                                    UiText.StringResource(resId = R.string.product_removed_favorites)
                                ),
                                favoriteList = currentList
                            )
                        }
                    }

                    is Response.Error -> {
                        _uiState.update {
                            it.copy(userMessages = listOf(
                                UiText.StringResource(resId = response.errorMessageId)
                            ))
                        }
                    }
                }
            }
        }
    }

    fun userMessagesConsumed() {
        _uiState.update {
            it.copy(userMessages = listOf())
        }
    }
}

data class FavoritesUiState(
    val isLoading: Boolean = false,
    val userMessages: List<UiText> = listOf(),
    val favoriteList: List<ProductEntity> = listOf()
)