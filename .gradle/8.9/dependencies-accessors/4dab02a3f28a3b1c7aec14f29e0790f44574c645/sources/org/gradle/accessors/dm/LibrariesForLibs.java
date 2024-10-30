package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final CoilLibraryAccessors laccForCoilLibraryAccessors = new CoilLibraryAccessors(owner);
    private final ConverterLibraryAccessors laccForConverterLibraryAccessors = new ConverterLibraryAccessors(owner);
    private final JetbrainsLibraryAccessors laccForJetbrainsLibraryAccessors = new JetbrainsLibraryAccessors(owner);
    private final MaterialLibraryAccessors laccForMaterialLibraryAccessors = new MaterialLibraryAccessors(owner);
    private final RetrofitLibraryAccessors laccForRetrofitLibraryAccessors = new RetrofitLibraryAccessors(owner);
    private final Retrofit2LibraryAccessors laccForRetrofit2LibraryAccessors = new Retrofit2LibraryAccessors(owner);
    private final SupportLibraryAccessors laccForSupportLibraryAccessors = new SupportLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Dependency provider for <b>gson</b> with <b>com.google.code.gson:gson</b> coordinates and
     * with version reference <b>gson</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getGson() {
        return create("gson");
    }

    /**
     * Dependency provider for <b>junit</b> with <b>junit:junit</b> coordinates and
     * with version reference <b>junit</b>
     * <p>
     * This dependency was declared in catalog libs.versions.toml
     */
    public Provider<MinimalExternalModuleDependency> getJunit() {
        return create("junit");
    }

    /**
     * Group of libraries at <b>androidx</b>
     */
    public AndroidxLibraryAccessors getAndroidx() {
        return laccForAndroidxLibraryAccessors;
    }

    /**
     * Group of libraries at <b>coil</b>
     */
    public CoilLibraryAccessors getCoil() {
        return laccForCoilLibraryAccessors;
    }

    /**
     * Group of libraries at <b>converter</b>
     */
    public ConverterLibraryAccessors getConverter() {
        return laccForConverterLibraryAccessors;
    }

    /**
     * Group of libraries at <b>jetbrains</b>
     */
    public JetbrainsLibraryAccessors getJetbrains() {
        return laccForJetbrainsLibraryAccessors;
    }

    /**
     * Group of libraries at <b>material</b>
     */
    public MaterialLibraryAccessors getMaterial() {
        return laccForMaterialLibraryAccessors;
    }

    /**
     * Group of libraries at <b>retrofit</b>
     */
    public RetrofitLibraryAccessors getRetrofit() {
        return laccForRetrofitLibraryAccessors;
    }

    /**
     * Group of libraries at <b>retrofit2</b>
     */
    public Retrofit2LibraryAccessors getRetrofit2() {
        return laccForRetrofit2LibraryAccessors;
    }

    /**
     * Group of libraries at <b>support</b>
     */
    public SupportLibraryAccessors getSupport() {
        return laccForSupportLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxActivityLibraryAccessors laccForAndroidxActivityLibraryAccessors = new AndroidxActivityLibraryAccessors(owner);
        private final AndroidxComposeLibraryAccessors laccForAndroidxComposeLibraryAccessors = new AndroidxComposeLibraryAccessors(owner);
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxEspressoLibraryAccessors laccForAndroidxEspressoLibraryAccessors = new AndroidxEspressoLibraryAccessors(owner);
        private final AndroidxJunitLibraryAccessors laccForAndroidxJunitLibraryAccessors = new AndroidxJunitLibraryAccessors(owner);
        private final AndroidxLifecycleLibraryAccessors laccForAndroidxLifecycleLibraryAccessors = new AndroidxLifecycleLibraryAccessors(owner);
        private final AndroidxMaterial3LibraryAccessors laccForAndroidxMaterial3LibraryAccessors = new AndroidxMaterial3LibraryAccessors(owner);
        private final AndroidxNavigationLibraryAccessors laccForAndroidxNavigationLibraryAccessors = new AndroidxNavigationLibraryAccessors(owner);
        private final AndroidxRoomLibraryAccessors laccForAndroidxRoomLibraryAccessors = new AndroidxRoomLibraryAccessors(owner);
        private final AndroidxRuntimeLibraryAccessors laccForAndroidxRuntimeLibraryAccessors = new AndroidxRuntimeLibraryAccessors(owner);
        private final AndroidxUiLibraryAccessors laccForAndroidxUiLibraryAccessors = new AndroidxUiLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>appcompat</b> with <b>androidx.appcompat:appcompat</b> coordinates and
         * with version reference <b>appcompat</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAppcompat() {
            return create("androidx.appcompat");
        }

        /**
         * Dependency provider for <b>constraintlayout</b> with <b>androidx.constraintlayout:constraintlayout</b> coordinates and
         * with version reference <b>constraintlayout</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getConstraintlayout() {
            return create("androidx.constraintlayout");
        }

        /**
         * Group of libraries at <b>androidx.activity</b>
         */
        public AndroidxActivityLibraryAccessors getActivity() {
            return laccForAndroidxActivityLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.compose</b>
         */
        public AndroidxComposeLibraryAccessors getCompose() {
            return laccForAndroidxComposeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.core</b>
         */
        public AndroidxCoreLibraryAccessors getCore() {
            return laccForAndroidxCoreLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.espresso</b>
         */
        public AndroidxEspressoLibraryAccessors getEspresso() {
            return laccForAndroidxEspressoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.junit</b>
         */
        public AndroidxJunitLibraryAccessors getJunit() {
            return laccForAndroidxJunitLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.lifecycle</b>
         */
        public AndroidxLifecycleLibraryAccessors getLifecycle() {
            return laccForAndroidxLifecycleLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.material3</b>
         */
        public AndroidxMaterial3LibraryAccessors getMaterial3() {
            return laccForAndroidxMaterial3LibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.navigation</b>
         */
        public AndroidxNavigationLibraryAccessors getNavigation() {
            return laccForAndroidxNavigationLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.room</b>
         */
        public AndroidxRoomLibraryAccessors getRoom() {
            return laccForAndroidxRoomLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.runtime</b>
         */
        public AndroidxRuntimeLibraryAccessors getRuntime() {
            return laccForAndroidxRuntimeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.ui</b>
         */
        public AndroidxUiLibraryAccessors getUi() {
            return laccForAndroidxUiLibraryAccessors;
        }

    }

    public static class AndroidxActivityLibraryAccessors extends SubDependencyFactory {

        public AndroidxActivityLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.activity:activity-compose</b> coordinates and
         * with version reference <b>activityCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("androidx.activity.compose");
        }

    }

    public static class AndroidxComposeLibraryAccessors extends SubDependencyFactory {
        private final AndroidxComposeBomLibraryAccessors laccForAndroidxComposeBomLibraryAccessors = new AndroidxComposeBomLibraryAccessors(owner);

        public AndroidxComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.compose.bom</b>
         */
        public AndroidxComposeBomLibraryAccessors getBom() {
            return laccForAndroidxComposeBomLibraryAccessors;
        }

    }

    public static class AndroidxComposeBomLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxComposeBomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>bom</b> with <b>androidx.compose:compose-bom</b> coordinates and
         * with version reference <b>composeBom</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.compose.bom");
        }

        /**
         * Dependency provider for <b>v2021110</b> with <b>androidx.compose:compose-bom</b> coordinates and
         * with version reference <b>composeBomVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV2021110() {
            return create("androidx.compose.bom.v2021110");
        }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {
        private final AndroidxCoreKtxLibraryAccessors laccForAndroidxCoreKtxLibraryAccessors = new AndroidxCoreKtxLibraryAccessors(owner);

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.core.ktx</b>
         */
        public AndroidxCoreKtxLibraryAccessors getKtx() {
            return laccForAndroidxCoreKtxLibraryAccessors;
        }

    }

    public static class AndroidxCoreKtxLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxCoreKtxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.core:core-ktx</b> coordinates and
         * with version reference <b>coreKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.core.ktx");
        }

        /**
         * Dependency provider for <b>v170</b> with <b>androidx.core:core-ktx</b> coordinates and
         * with version reference <b>coreKtxVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV170() {
            return create("androidx.core.ktx.v170");
        }

    }

    public static class AndroidxEspressoLibraryAccessors extends SubDependencyFactory {
        private final AndroidxEspressoCoreLibraryAccessors laccForAndroidxEspressoCoreLibraryAccessors = new AndroidxEspressoCoreLibraryAccessors(owner);

        public AndroidxEspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.espresso.core</b>
         */
        public AndroidxEspressoCoreLibraryAccessors getCore() {
            return laccForAndroidxEspressoCoreLibraryAccessors;
        }

    }

    public static class AndroidxEspressoCoreLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxEspressoCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>androidx.test.espresso:espresso-core</b> coordinates and
         * with version reference <b>espressoCore</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.espresso.core");
        }

        /**
         * Dependency provider for <b>v340</b> with <b>androidx.test.espresso:espresso-core</b> coordinates and
         * with version reference <b>espressoCoreVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV340() {
            return create("androidx.espresso.core.v340");
        }

    }

    public static class AndroidxJunitLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxJunitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit</b> with <b>androidx.test.ext:junit</b> coordinates and
         * with version reference <b>junitVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.junit");
        }

        /**
         * Dependency provider for <b>v113</b> with <b>androidx.test.ext:junit</b> coordinates and
         * with version reference <b>androidxJunit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV113() {
            return create("androidx.junit.v113");
        }

    }

    public static class AndroidxLifecycleLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleLivedataLibraryAccessors laccForAndroidxLifecycleLivedataLibraryAccessors = new AndroidxLifecycleLivedataLibraryAccessors(owner);
        private final AndroidxLifecycleRuntimeLibraryAccessors laccForAndroidxLifecycleRuntimeLibraryAccessors = new AndroidxLifecycleRuntimeLibraryAccessors(owner);
        private final AndroidxLifecycleViewmodelLibraryAccessors laccForAndroidxLifecycleViewmodelLibraryAccessors = new AndroidxLifecycleViewmodelLibraryAccessors(owner);

        public AndroidxLifecycleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.lifecycle.livedata</b>
         */
        public AndroidxLifecycleLivedataLibraryAccessors getLivedata() {
            return laccForAndroidxLifecycleLivedataLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.lifecycle.runtime</b>
         */
        public AndroidxLifecycleRuntimeLibraryAccessors getRuntime() {
            return laccForAndroidxLifecycleRuntimeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.lifecycle.viewmodel</b>
         */
        public AndroidxLifecycleViewmodelLibraryAccessors getViewmodel() {
            return laccForAndroidxLifecycleViewmodelLibraryAccessors;
        }

    }

    public static class AndroidxLifecycleLivedataLibraryAccessors extends SubDependencyFactory {
        private final AndroidxLifecycleLivedataKtxLibraryAccessors laccForAndroidxLifecycleLivedataKtxLibraryAccessors = new AndroidxLifecycleLivedataKtxLibraryAccessors(owner);

        public AndroidxLifecycleLivedataLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.lifecycle.livedata.ktx</b>
         */
        public AndroidxLifecycleLivedataKtxLibraryAccessors getKtx() {
            return laccForAndroidxLifecycleLivedataKtxLibraryAccessors;
        }

    }

    public static class AndroidxLifecycleLivedataKtxLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxLifecycleLivedataKtxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.lifecycle:lifecycle-livedata-ktx</b> coordinates and
         * with version reference <b>lifecycleLivedataKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.lifecycle.livedata.ktx");
        }

        /**
         * Dependency provider for <b>v240</b> with <b>androidx.lifecycle:lifecycle-livedata-ktx</b> coordinates and
         * with version reference <b>lifecycleLivedataKtxVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV240() {
            return create("androidx.lifecycle.livedata.ktx.v240");
        }

    }

    public static class AndroidxLifecycleRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.lifecycle:lifecycle-runtime-ktx</b> coordinates and
         * with version reference <b>lifecycleLivedataKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.lifecycle.runtime.ktx");
        }

    }

    public static class AndroidxLifecycleViewmodelLibraryAccessors extends SubDependencyFactory {

        public AndroidxLifecycleViewmodelLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.lifecycle:lifecycle-viewmodel-ktx</b> coordinates and
         * with version reference <b>lifecycleViewmodelKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.lifecycle.viewmodel.ktx");
        }

    }

    public static class AndroidxMaterial3LibraryAccessors extends SubDependencyFactory {

        public AndroidxMaterial3LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>android</b> with <b>androidx.compose.material3:material3-android</b> coordinates and
         * with version reference <b>material3Android</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            return create("androidx.material3.android");
        }

        /**
         * Dependency provider for <b>desktop</b> with <b>androidx.compose.material3:material3-desktop</b> coordinates and
         * with version reference <b>material3Desktop</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDesktop() {
            return create("androidx.material3.desktop");
        }

    }

    public static class AndroidxNavigationLibraryAccessors extends SubDependencyFactory {
        private final AndroidxNavigationComposeLibraryAccessors laccForAndroidxNavigationComposeLibraryAccessors = new AndroidxNavigationComposeLibraryAccessors(owner);
        private final AndroidxNavigationDynamicLibraryAccessors laccForAndroidxNavigationDynamicLibraryAccessors = new AndroidxNavigationDynamicLibraryAccessors(owner);
        private final AndroidxNavigationFragmentLibraryAccessors laccForAndroidxNavigationFragmentLibraryAccessors = new AndroidxNavigationFragmentLibraryAccessors(owner);
        private final AndroidxNavigationUiLibraryAccessors laccForAndroidxNavigationUiLibraryAccessors = new AndroidxNavigationUiLibraryAccessors(owner);

        public AndroidxNavigationLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>testing</b> with <b>androidx.navigation:navigation-testing</b> coordinates and
         * with version reference <b>navigationFragmentKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTesting() {
            return create("androidx.navigation.testing");
        }

        /**
         * Group of libraries at <b>androidx.navigation.compose</b>
         */
        public AndroidxNavigationComposeLibraryAccessors getCompose() {
            return laccForAndroidxNavigationComposeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.navigation.dynamic</b>
         */
        public AndroidxNavigationDynamicLibraryAccessors getDynamic() {
            return laccForAndroidxNavigationDynamicLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.navigation.fragment</b>
         */
        public AndroidxNavigationFragmentLibraryAccessors getFragment() {
            return laccForAndroidxNavigationFragmentLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.navigation.ui</b>
         */
        public AndroidxNavigationUiLibraryAccessors getUi() {
            return laccForAndroidxNavigationUiLibraryAccessors;
        }

    }

    public static class AndroidxNavigationComposeLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxNavigationComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>androidx.navigation:navigation-compose</b> coordinates and
         * with version reference <b>navigationCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.navigation.compose");
        }

        /**
         * Dependency provider for <b>v240</b> with <b>androidx.navigation:navigation-compose</b> coordinates and
         * with version reference <b>navigationComposeVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV240() {
            return create("androidx.navigation.compose.v240");
        }

    }

    public static class AndroidxNavigationDynamicLibraryAccessors extends SubDependencyFactory {
        private final AndroidxNavigationDynamicFeaturesLibraryAccessors laccForAndroidxNavigationDynamicFeaturesLibraryAccessors = new AndroidxNavigationDynamicFeaturesLibraryAccessors(owner);

        public AndroidxNavigationDynamicLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.navigation.dynamic.features</b>
         */
        public AndroidxNavigationDynamicFeaturesLibraryAccessors getFeatures() {
            return laccForAndroidxNavigationDynamicFeaturesLibraryAccessors;
        }

    }

    public static class AndroidxNavigationDynamicFeaturesLibraryAccessors extends SubDependencyFactory {

        public AndroidxNavigationDynamicFeaturesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>fragment</b> with <b>androidx.navigation:navigation-dynamic-features-fragment</b> coordinates and
         * with version reference <b>navigationFragmentKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFragment() {
            return create("androidx.navigation.dynamic.features.fragment");
        }

    }

    public static class AndroidxNavigationFragmentLibraryAccessors extends SubDependencyFactory {
        private final AndroidxNavigationFragmentKtxLibraryAccessors laccForAndroidxNavigationFragmentKtxLibraryAccessors = new AndroidxNavigationFragmentKtxLibraryAccessors(owner);

        public AndroidxNavigationFragmentLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.navigation.fragment.ktx</b>
         */
        public AndroidxNavigationFragmentKtxLibraryAccessors getKtx() {
            return laccForAndroidxNavigationFragmentKtxLibraryAccessors;
        }

    }

    public static class AndroidxNavigationFragmentKtxLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxNavigationFragmentKtxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.navigation:navigation-fragment-ktx</b> coordinates and
         * with version reference <b>navigationFragmentKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.navigation.fragment.ktx");
        }

        /**
         * Dependency provider for <b>v240</b> with <b>androidx.navigation:navigation-fragment-ktx</b> coordinates and
         * with version reference <b>navigationFragmentKtxVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV240() {
            return create("androidx.navigation.fragment.ktx.v240");
        }

    }

    public static class AndroidxNavigationUiLibraryAccessors extends SubDependencyFactory {
        private final AndroidxNavigationUiKtxLibraryAccessors laccForAndroidxNavigationUiKtxLibraryAccessors = new AndroidxNavigationUiKtxLibraryAccessors(owner);

        public AndroidxNavigationUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.navigation.ui.ktx</b>
         */
        public AndroidxNavigationUiKtxLibraryAccessors getKtx() {
            return laccForAndroidxNavigationUiKtxLibraryAccessors;
        }

    }

    public static class AndroidxNavigationUiKtxLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxNavigationUiKtxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.navigation:navigation-ui-ktx</b> coordinates and
         * with version reference <b>navigationUiKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.navigation.ui.ktx");
        }

        /**
         * Dependency provider for <b>v240</b> with <b>androidx.navigation:navigation-ui-ktx</b> coordinates and
         * with version reference <b>navigationUiKtxVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV240() {
            return create("androidx.navigation.ui.ktx.v240");
        }

    }

    public static class AndroidxRoomLibraryAccessors extends SubDependencyFactory {

        public AndroidxRoomLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compiler</b> with <b>androidx.room:room-compiler</b> coordinates and
         * with version reference <b>roomKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompiler() {
            return create("androidx.room.compiler");
        }

        /**
         * Dependency provider for <b>ktx</b> with <b>androidx.room:room-ktx</b> coordinates and
         * with version reference <b>roomKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKtx() {
            return create("androidx.room.ktx");
        }

        /**
         * Dependency provider for <b>runtime</b> with <b>androidx.room:room-runtime</b> coordinates and
         * with version reference <b>roomKtx</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getRuntime() {
            return create("androidx.room.runtime");
        }

    }

    public static class AndroidxRuntimeLibraryAccessors extends SubDependencyFactory {

        public AndroidxRuntimeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>livedata</b> with <b>androidx.compose.runtime:runtime-livedata</b> coordinates and
         * with version reference <b>runtimeLivedata</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLivedata() {
            return create("androidx.runtime.livedata");
        }

    }

    public static class AndroidxUiLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxUiTestLibraryAccessors laccForAndroidxUiTestLibraryAccessors = new AndroidxUiTestLibraryAccessors(owner);
        private final AndroidxUiTextLibraryAccessors laccForAndroidxUiTextLibraryAccessors = new AndroidxUiTextLibraryAccessors(owner);
        private final AndroidxUiToolingLibraryAccessors laccForAndroidxUiToolingLibraryAccessors = new AndroidxUiToolingLibraryAccessors(owner);

        public AndroidxUiLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>ui</b> with <b>androidx.compose.ui:ui</b> coordinates and
         * with version reference <b>uiToolingPreviewAndroid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.ui");
        }

        /**
         * Dependency provider for <b>graphics</b> with <b>androidx.compose.ui:ui-graphics</b> coordinates and
         * with version reference <b>uiToolingPreviewAndroid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGraphics() {
            return create("androidx.ui.graphics");
        }

        /**
         * Group of libraries at <b>androidx.ui.test</b>
         */
        public AndroidxUiTestLibraryAccessors getTest() {
            return laccForAndroidxUiTestLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.ui.text</b>
         */
        public AndroidxUiTextLibraryAccessors getText() {
            return laccForAndroidxUiTextLibraryAccessors;
        }

        /**
         * Group of libraries at <b>androidx.ui.tooling</b>
         */
        public AndroidxUiToolingLibraryAccessors getTooling() {
            return laccForAndroidxUiToolingLibraryAccessors;
        }

    }

    public static class AndroidxUiTestLibraryAccessors extends SubDependencyFactory {

        public AndroidxUiTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>junit4</b> with <b>androidx.compose.ui:ui-test-junit4</b> coordinates and
         * with version reference <b>uiToolingPreviewAndroid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit4() {
            return create("androidx.ui.test.junit4");
        }

        /**
         * Dependency provider for <b>manifest</b> with <b>androidx.compose.ui:ui-test-manifest</b> coordinates and
         * with version reference <b>uiToolingPreviewAndroid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getManifest() {
            return create("androidx.ui.test.manifest");
        }

    }

    public static class AndroidxUiTextLibraryAccessors extends SubDependencyFactory {
        private final AndroidxUiTextGoogleLibraryAccessors laccForAndroidxUiTextGoogleLibraryAccessors = new AndroidxUiTextGoogleLibraryAccessors(owner);

        public AndroidxUiTextLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>androidx.ui.text.google</b>
         */
        public AndroidxUiTextGoogleLibraryAccessors getGoogle() {
            return laccForAndroidxUiTextGoogleLibraryAccessors;
        }

    }

    public static class AndroidxUiTextGoogleLibraryAccessors extends SubDependencyFactory {

        public AndroidxUiTextGoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>fonts</b> with <b>androidx.compose.ui:ui-text-google-fonts</b> coordinates and
         * with version reference <b>uiTextGoogleFonts</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getFonts() {
            return create("androidx.ui.text.google.fonts");
        }

    }

    public static class AndroidxUiToolingLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final AndroidxUiToolingPreviewLibraryAccessors laccForAndroidxUiToolingPreviewLibraryAccessors = new AndroidxUiToolingPreviewLibraryAccessors(owner);

        public AndroidxUiToolingLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>tooling</b> with <b>androidx.compose.ui:ui-tooling</b> coordinates and
         * with version reference <b>uiToolingPreviewAndroid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.ui.tooling");
        }

        /**
         * Group of libraries at <b>androidx.ui.tooling.preview</b>
         */
        public AndroidxUiToolingPreviewLibraryAccessors getPreview() {
            return laccForAndroidxUiToolingPreviewLibraryAccessors;
        }

    }

    public static class AndroidxUiToolingPreviewLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AndroidxUiToolingPreviewLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>preview</b> with <b>androidx.compose.ui:ui-tooling-preview</b> coordinates and
         * with version reference <b>uiToolingPreviewAndroid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("androidx.ui.tooling.preview");
        }

        /**
         * Dependency provider for <b>android</b> with <b>androidx.compose.ui:ui-tooling-preview-android</b> coordinates and
         * with version reference <b>uiToolingPreviewAndroid</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroid() {
            return create("androidx.ui.tooling.preview.android");
        }

    }

    public static class CoilLibraryAccessors extends SubDependencyFactory {
        private final CoilComposeLibraryAccessors laccForCoilComposeLibraryAccessors = new CoilComposeLibraryAccessors(owner);
        private final CoilKtLibraryAccessors laccForCoilKtLibraryAccessors = new CoilKtLibraryAccessors(owner);

        public CoilLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>coil.compose</b>
         */
        public CoilComposeLibraryAccessors getCompose() {
            return laccForCoilComposeLibraryAccessors;
        }

        /**
         * Group of libraries at <b>coil.kt</b>
         */
        public CoilKtLibraryAccessors getKt() {
            return laccForCoilKtLibraryAccessors;
        }

    }

    public static class CoilComposeLibraryAccessors extends SubDependencyFactory {

        public CoilComposeLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>v140</b> with <b>io.coil-kt:coil-compose</b> coordinates and
         * with version reference <b>coilCompose</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV140() {
            return create("coil.compose.v140");
        }

    }

    public static class CoilKtLibraryAccessors extends SubDependencyFactory {
        private final CoilKtCoilLibraryAccessors laccForCoilKtCoilLibraryAccessors = new CoilKtCoilLibraryAccessors(owner);

        public CoilKtLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>coil.kt.coil</b>
         */
        public CoilKtCoilLibraryAccessors getCoil() {
            return laccForCoilKtCoilLibraryAccessors;
        }

    }

    public static class CoilKtCoilLibraryAccessors extends SubDependencyFactory {

        public CoilKtCoilLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>compose</b> with <b>io.coil-kt:coil-compose</b> coordinates and
         * with version reference <b>coilComposeVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCompose() {
            return create("coil.kt.coil.compose");
        }

    }

    public static class ConverterLibraryAccessors extends SubDependencyFactory {

        public ConverterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>gson</b> with <b>com.squareup..retrofit2:converter-gson</b> coordinates and
         * with version reference <b>converterGson</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGson() {
            return create("converter.gson");
        }

    }

    public static class JetbrainsLibraryAccessors extends SubDependencyFactory {
        private final JetbrainsKotlinxLibraryAccessors laccForJetbrainsKotlinxLibraryAccessors = new JetbrainsKotlinxLibraryAccessors(owner);

        public JetbrainsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jetbrains.kotlinx</b>
         */
        public JetbrainsKotlinxLibraryAccessors getKotlinx() {
            return laccForJetbrainsKotlinxLibraryAccessors;
        }

    }

    public static class JetbrainsKotlinxLibraryAccessors extends SubDependencyFactory {
        private final JetbrainsKotlinxCoroutinesLibraryAccessors laccForJetbrainsKotlinxCoroutinesLibraryAccessors = new JetbrainsKotlinxCoroutinesLibraryAccessors(owner);

        public JetbrainsKotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>jetbrains.kotlinx.coroutines</b>
         */
        public JetbrainsKotlinxCoroutinesLibraryAccessors getCoroutines() {
            return laccForJetbrainsKotlinxCoroutinesLibraryAccessors;
        }

    }

    public static class JetbrainsKotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {

        public JetbrainsKotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.jetbrains.kotlinx:kotlinx-coroutines-core</b> coordinates and
         * with version reference <b>kotlinxCoroutinesCoreVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("jetbrains.kotlinx.coroutines.core");
        }

    }

    public static class MaterialLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public MaterialLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>material</b> with <b>com.google.android.material:material</b> coordinates and
         * with version reference <b>material</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("material");
        }

        /**
         * Dependency provider for <b>v140</b> with <b>com.google.android.material:material</b> coordinates and
         * with version reference <b>materialVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV140() {
            return create("material.v140");
        }

    }

    public static class RetrofitLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public RetrofitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>retrofit</b> with <b>com.squareup.retrofit2:retrofit</b> coordinates and
         * with version reference <b>retrofit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("retrofit");
        }

        /**
         * Dependency provider for <b>v290</b> with <b>com.squareup.retrofit2:retrofit</b> coordinates and
         * with version reference <b>retrofitVersion</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getV290() {
            return create("retrofit.v290");
        }

    }

    public static class Retrofit2LibraryAccessors extends SubDependencyFactory {
        private final Retrofit2ConverterLibraryAccessors laccForRetrofit2ConverterLibraryAccessors = new Retrofit2ConverterLibraryAccessors(owner);

        public Retrofit2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>retrofit2.converter</b>
         */
        public Retrofit2ConverterLibraryAccessors getConverter() {
            return laccForRetrofit2ConverterLibraryAccessors;
        }

    }

    public static class Retrofit2ConverterLibraryAccessors extends SubDependencyFactory {

        public Retrofit2ConverterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>gson</b> with <b>com.squareup.retrofit2:converter-gson</b> coordinates and
         * with version reference <b>retrofit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGson() {
            return create("retrofit2.converter.gson");
        }

    }

    public static class SupportLibraryAccessors extends SubDependencyFactory {

        public SupportLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>annotations</b> with <b>com.android.support:support-annotations</b> coordinates and
         * with version reference <b>supportAnnotations</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnnotations() {
            return create("support.annotations");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>activityCompose</b> with value <b>1.9.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getActivityCompose() { return getVersion("activityCompose"); }

        /**
         * Version alias <b>agp</b> with value <b>8.7.0-alpha08</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAgp() { return getVersion("agp"); }

        /**
         * Version alias <b>androidxJunit</b> with value <b>1.1.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAndroidxJunit() { return getVersion("androidxJunit"); }

        /**
         * Version alias <b>appcompat</b> with value <b>1.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAppcompat() { return getVersion("appcompat"); }

        /**
         * Version alias <b>coilCompose</b> with value <b>1.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoilCompose() { return getVersion("coilCompose"); }

        /**
         * Version alias <b>coilComposeVersion</b> with value <b>2.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoilComposeVersion() { return getVersion("coilComposeVersion"); }

        /**
         * Version alias <b>composeBom</b> with value <b>2024.10.00</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeBom() { return getVersion("composeBom"); }

        /**
         * Version alias <b>composeBomVersion</b> with value <b>2021.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getComposeBomVersion() { return getVersion("composeBomVersion"); }

        /**
         * Version alias <b>constraintlayout</b> with value <b>2.1.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getConstraintlayout() { return getVersion("constraintlayout"); }

        /**
         * Version alias <b>converterGson</b> with value <b>2.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getConverterGson() { return getVersion("converterGson"); }

        /**
         * Version alias <b>coreKtx</b> with value <b>1.13.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoreKtx() { return getVersion("coreKtx"); }

        /**
         * Version alias <b>coreKtxVersion</b> with value <b>1.7.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getCoreKtxVersion() { return getVersion("coreKtxVersion"); }

        /**
         * Version alias <b>espressoCore</b> with value <b>3.6.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getEspressoCore() { return getVersion("espressoCore"); }

        /**
         * Version alias <b>espressoCoreVersion</b> with value <b>3.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getEspressoCoreVersion() { return getVersion("espressoCoreVersion"); }

        /**
         * Version alias <b>gson</b> with value <b>2.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGson() { return getVersion("gson"); }

        /**
         * Version alias <b>junit</b> with value <b>4.13.2</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunit() { return getVersion("junit"); }

        /**
         * Version alias <b>junitVersion</b> with value <b>1.2.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getJunitVersion() { return getVersion("junitVersion"); }

        /**
         * Version alias <b>kotlin</b> with value <b>1.9.24</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlin() { return getVersion("kotlin"); }

        /**
         * Version alias <b>kotlinxCoroutinesCoreVersion</b> with value <b>1.3.9</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getKotlinxCoroutinesCoreVersion() { return getVersion("kotlinxCoroutinesCoreVersion"); }

        /**
         * Version alias <b>lifecycleLivedataKtx</b> with value <b>2.8.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleLivedataKtx() { return getVersion("lifecycleLivedataKtx"); }

        /**
         * Version alias <b>lifecycleLivedataKtxVersion</b> with value <b>2.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleLivedataKtxVersion() { return getVersion("lifecycleLivedataKtxVersion"); }

        /**
         * Version alias <b>lifecycleViewmodelKtx</b> with value <b>2.8.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLifecycleViewmodelKtx() { return getVersion("lifecycleViewmodelKtx"); }

        /**
         * Version alias <b>material</b> with value <b>1.12.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMaterial() { return getVersion("material"); }

        /**
         * Version alias <b>material3Android</b> with value <b>1.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMaterial3Android() { return getVersion("material3Android"); }

        /**
         * Version alias <b>material3Desktop</b> with value <b>1.3.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMaterial3Desktop() { return getVersion("material3Desktop"); }

        /**
         * Version alias <b>materialVersion</b> with value <b>1.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getMaterialVersion() { return getVersion("materialVersion"); }

        /**
         * Version alias <b>navigationCompose</b> with value <b>2.8.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigationCompose() { return getVersion("navigationCompose"); }

        /**
         * Version alias <b>navigationComposeVersion</b> with value <b>2.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigationComposeVersion() { return getVersion("navigationComposeVersion"); }

        /**
         * Version alias <b>navigationFragmentKtx</b> with value <b>2.8.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigationFragmentKtx() { return getVersion("navigationFragmentKtx"); }

        /**
         * Version alias <b>navigationFragmentKtxVersion</b> with value <b>2.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigationFragmentKtxVersion() { return getVersion("navigationFragmentKtxVersion"); }

        /**
         * Version alias <b>navigationUiKtx</b> with value <b>2.8.3</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigationUiKtx() { return getVersion("navigationUiKtx"); }

        /**
         * Version alias <b>navigationUiKtxVersion</b> with value <b>2.4.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getNavigationUiKtxVersion() { return getVersion("navigationUiKtxVersion"); }

        /**
         * Version alias <b>retrofit</b> with value <b>2.11.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRetrofit() { return getVersion("retrofit"); }

        /**
         * Version alias <b>retrofitVersion</b> with value <b>2.9.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRetrofitVersion() { return getVersion("retrofitVersion"); }

        /**
         * Version alias <b>roomKtx</b> with value <b>2.6.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRoomKtx() { return getVersion("roomKtx"); }

        /**
         * Version alias <b>runtimeLivedata</b> with value <b>1.7.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getRuntimeLivedata() { return getVersion("runtimeLivedata"); }

        /**
         * Version alias <b>supportAnnotations</b> with value <b>28.0.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getSupportAnnotations() { return getVersion("supportAnnotations"); }

        /**
         * Version alias <b>uiTextGoogleFonts</b> with value <b>1.7.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getUiTextGoogleFonts() { return getVersion("uiTextGoogleFonts"); }

        /**
         * Version alias <b>uiToolingPreviewAndroid</b> with value <b>1.7.4</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getUiToolingPreviewAndroid() { return getVersion("uiToolingPreviewAndroid"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final AndroidPluginAccessors paccForAndroidPluginAccessors = new AndroidPluginAccessors(providers, config);
        private final KotlinPluginAccessors paccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of plugins at <b>plugins.android</b>
         */
        public AndroidPluginAccessors getAndroid() {
            return paccForAndroidPluginAccessors;
        }

        /**
         * Group of plugins at <b>plugins.kotlin</b>
         */
        public KotlinPluginAccessors getKotlin() {
            return paccForKotlinPluginAccessors;
        }

    }

    public static class AndroidPluginAccessors extends PluginFactory {

        public AndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>android.application</b> with plugin id <b>com.android.application</b> and
         * with version reference <b>agp</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getApplication() { return createPlugin("android.application"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Plugin provider for <b>kotlin.android</b> with plugin id <b>org.jetbrains.kotlin.android</b> and
         * with version reference <b>kotlin</b>
         * <p>
         * This plugin was declared in catalog libs.versions.toml
         */
        public Provider<PluginDependency> getAndroid() { return createPlugin("kotlin.android"); }

    }

}
